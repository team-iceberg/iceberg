import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexLayoutModule} from '@angular/flex-layout';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';
import {MaterialModule} from '../shared/material/material.module';
import {SharedModule} from '../shared/shared.module';

import {LoginComponent} from './component/login.component';
import {LoginRoutingModule} from './login-routing.module';


@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        CommonModule,
        MaterialModule,
        LoginRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        SharedModule,
        FlexLayoutModule,
        TranslateModule
    ],
    providers: [],
    bootstrap: [LoginComponent]
})

export class LoginModule {
}
