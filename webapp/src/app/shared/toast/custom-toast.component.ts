import {Component, Inject} from '@angular/core';
import {MAT_SNACK_BAR_DATA, MatSnackBarRef} from '@angular/material';

@Component({
    selector: 'custom-toast',
    templateUrl: './custom-toast.component.html',
    styleUrls: ['./custom-toast.component.less']
})
export class CustomToastComponent {

    public snackBarRef: MatSnackBarRef<CustomToastComponent>;

    constructor(@Inject(MAT_SNACK_BAR_DATA) public data: any) {

    }

    public close(): void {
        this.snackBarRef.dismiss();
    }
}
