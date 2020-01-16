import {Injectable} from '@angular/core';
import {MatSnackBar, MatSnackBarRef} from '@angular/material';
import {CustomToastComponent} from './custom-toast.component';


@Injectable()
export class ToastService {

    private defaultDuration = 3000;

    constructor(private snackBar: MatSnackBar) {
    }

    openCustomToast(message: string, classes: string[], duration?: number) {
        let matSnackBarRef: MatSnackBarRef<CustomToastComponent> = this.snackBar.openFromComponent(CustomToastComponent, {
            data: message,
            horizontalPosition: 'right',
            verticalPosition: 'bottom',
            duration: duration ? duration : this.defaultDuration,
            panelClass: classes
        });

        matSnackBarRef.instance.snackBarRef = matSnackBarRef;

    }

    info(message: string, duration?: number) {
        this.openCustomToast(message, ['info-snackbar'], duration ? duration : this.defaultDuration);
    }

    warning(message: string, duration?: number) {
        this.openCustomToast(message, ['warning-snackbar'], duration ? duration : this.defaultDuration);
    }

    alert(message: string, duration?: number) {
        this.openCustomToast(message, ['alert-snackbar'], duration ? duration : this.defaultDuration);
    }

}
