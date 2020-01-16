import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';


@Injectable()
export class AuthenticationService {

    constructor(private http: HttpClient) {
    }

    savesResponse(responce) {
        let url = 'http://localhost:64726/Api/Login/Savesresponse';
        return this.http.post(url, responce);
    }
}
