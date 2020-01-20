import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {User} from '../models/user';
import {StorageService} from '../tools/storage.service';


@Injectable()
export class AuthenticationService {

    constructor(private storageService: StorageService, private http: HttpClient) {
    }

    public get user(): User {
        return this.storageService.getUserContact();
    }

    public set user(userContact: User) {
        this.storageService.saveUserContact(userContact);
    };

    removeUser(): void {
        this.storageService.removeUser();
    }
}
