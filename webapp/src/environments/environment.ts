import {LoggerLevel} from '../app/models/logger-level';

export const environment = {
    production: false,
    BACKEND_BASE_URL: 'http://localhost:8080/',
    BASE_URL: window.location.origin,
    LOGGER_LEVEL: LoggerLevel.INFO
};
