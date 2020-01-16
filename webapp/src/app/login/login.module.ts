import {NgModule} from '@angular/core';

import {LoginComponent} from './component/login.component';
import {LoginRoutingModule} from './login-routing.module';


@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        LoginRoutingModule
    ],
    providers: [],
    bootstrap: [LoginComponent]
})

export class LoginModule {
}
