import {Injectable} from '@angular/core';
import {User} from '../models/user';


@Injectable()
export class StorageService {

    USER_KEY = 'USER-KEY';

    /**
     * Retourne une entrée en fonction de sa clé.
     *
     * @param key la clé à chercher
     */
    get(key: string): any {
        return JSON.parse(sessionStorage.getItem(key));
    }

    /**
     * Sauvegarde une entrée
     *
     * @param key la clé
     * @param data la donnée
     */
    save(key: string, data: any): void {
        sessionStorage.setItem(key, JSON.stringify(data));
    }

    /**
     * Supprime une entrée en fonction de sa clé
     *
     * @param key la clé
     */
    remove(key: string): void {
        sessionStorage.removeItem(key);
    }

    saveUserContact(user: User): void {
        this.save(this.USER_KEY, user);
    }

    getUserContact(): User {
        return this.get(this.USER_KEY);
    }

    removeUser(): void {
        this.remove(this.USER_KEY);
    }

    clear(): void {
        sessionStorage.clear();
    }
}
