FROM python:3.11

WORKDIR /app

COPY dist/ds_service-1.0.tar.gz .

RUN pip install --no-cache-dir ./ds_service-1.0.tar.gz

EXPOSE 8010

CMD ["python", "app.py"]