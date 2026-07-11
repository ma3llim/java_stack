package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
    private List<Train> trainList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAINS_PATH = "app/src/main/resources/localDb/trains.json";

    public TrainService() throws IOException {
        this.trainList = loadTrains();
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
}
