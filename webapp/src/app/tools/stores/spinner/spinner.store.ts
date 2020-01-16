import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable()
export class SpinnerStore {
    isLoading = new Subject<boolean>();

    activate() {
        this.isLoading.next(true);
    }

    deactivate() {
        this.isLoading.next(false);
    }
}
