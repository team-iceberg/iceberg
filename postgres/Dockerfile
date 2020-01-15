FROM postgres:9.6
USER postgres
COPY postgresql.conf /etc/postgresql/postgresql.conf
ENV POSTGRES_PASSWORD iceberg
ENV POSTGRES_DB iceberg
ENV POSTGRES_USER iceberg
EXPOSE 5433
CMD ["postgres", "-c", "config_file=/etc/postgresql/postgresql.conf"]
