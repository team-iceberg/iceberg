import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Association} from '../../models/association';

@Injectable()
export class AssociationService {

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<Association[]> {
        return this.http.get<Association[]>('association');
    }
}
