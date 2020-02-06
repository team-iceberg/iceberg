import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Family} from '../../models/family';

@Injectable()
export class FamilyService {

constructor(private http: HttpClient) {
    }

    getAll(): Observable<Family[]> {
        return this.http.get<Family[]>('iceberg/families');
    }
}
