import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Coloris} from '../../models/coloris';

@Injectable()
export class ColorisService {

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<Coloris[]> {
        return this.http.get<Coloris[]>('iceberg/coloris');
    }
}
