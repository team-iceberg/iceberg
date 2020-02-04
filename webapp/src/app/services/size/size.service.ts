import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Size} from '../../models/size';

@Injectable()
export class SizeService {

constructor(private http: HttpClient) {
    }

    getAll(): Observable<Size[]> {
        return this.http.get<Size[]>('iceberg/sizes');
    }
}
