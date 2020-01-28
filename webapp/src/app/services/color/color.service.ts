import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Color} from '../../models/color';

@Injectable()
export class ColorService {

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<Color[]> {
        return this.http.get<Color[]>('iceberg/colors');
    }
}
