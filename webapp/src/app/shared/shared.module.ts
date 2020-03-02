import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexLayoutModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';
import {SpinnerStore} from '../tools/stores/spinner/spinner.store';
import {MaterialModule} from './material/material.module';
import {SpinnerComponent} from './spinner/spinner.component';
import {CustomToastComponent} from './toast/custom-toast.component';
import {ToastService} from './toast/toast.service';


@NgModule({
    declarations: [
        CustomToastComponent,
        SpinnerComponent
    ],
    imports: [
        CommonModule,
        MaterialModule,
        TranslateModule,
        FormsModule,
        ReactiveFormsModule,
        FlexLayoutModule
    ],
    entryComponents: [CustomToastComponent, SpinnerComponent],
    exports: [SpinnerComponent],
    providers: [ToastService, SpinnerStore]
})

export class SharedModule {
}




