package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainService {
    private List<Train> trainList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAINS_PATH = "app/src/main/resources/localDb/trains.json";

    public TrainService() throws IOException {
        this.trainList = loadTrains();
    }

    public static List<List<Integer>> getSeats(Train train) {
        return train.getSeats();
    }

    public List<Train> loadTrains() throws IOException {
        File TrainsFile = new File(TRAINS_PATH);

        // If file doesn't exist, create it with empty list
        if (!TrainsFile.exists()) {
            TrainsFile.getParentFile().mkdirs();
            TrainsFile.createNewFile();
            objectMapper.readValue(TrainsFile, new TypeReference<List<Train>>() {
            });
            return new ArrayList<>();
        }
        return objectMapper.readValue(TrainsFile, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String source, String destination) {
        List<String> stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }


    public void addTrain(Train train) {
        trainList.add(train);
        try {
            saveTrainListToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTrainListToFile() throws IOException {
        File trainFile = new File(TRAINS_PATH);
        trainFile.getParentFile().mkdirs();
        objectMapper.writeValue(trainFile, trainList);
    }

    public void updateTrain(Train train) {
        Optional<Train> existedTrain = trainList.stream().filter(t -> t.getTrainId().equals(train.getTrainId())).findFirst();

        if (existedTrain.isEmpty()) {
            System.out.println("Train Is Not Found");
        }

        Train existingTrain = existedTrain.get();
        existingTrain.setSeats(train.getSeats());
        try {
            saveTrainListToFile();
            System.out.println("Train updated successfully!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to save train data", e);
        }

    }
}
