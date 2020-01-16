import {Component} from '@angular/core';
import {Subject} from 'rxjs';
import {SpinnerStore} from '../../tools/stores/spinner/spinner.store';

@Component({
    selector: 'cex-spinner',
    templateUrl: './spinner.component.html',
    styleUrls: ['./spinner.component.scss']
})
export class SpinnerComponent {
    isLoading: Subject<boolean> = this.spinnerStore.isLoading;

    constructor(private spinnerStore: SpinnerStore) {
    }
}
