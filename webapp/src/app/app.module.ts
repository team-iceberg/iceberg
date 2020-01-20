import {HttpClientModule, HTTP_INTERCEPTORS, HttpClient} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {AuthServiceConfig, GoogleLoginProvider, AuthService, SocialLoginModule} from 'angularx-social-login';
import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {HomeModule} from './home/home.module';
import {LoginModule} from './login/login.module';
import {AuthenticationService} from './services/authentication.service';
import {SharedModule} from './shared/shared.module';
import {UrlInterceptor} from './tools/interceptors/url/url.interceptor';
import {StorageService} from './tools/storage.service';
import {SpinnerStore} from './tools/stores/spinner/spinner.store';

export function HttpLoaderFactory(http: HttpClient) {
    return new TranslateHttpLoader(http);
}

export function socialConfigs() {
    return new AuthServiceConfig(
        [
            {
                id: GoogleLoginProvider.PROVIDER_ID,
                provider: new GoogleLoginProvider('854308350863-p7d0q7l8s2shvgmrakngoav58926h56m.apps.googleusercontent.com')
            }
        ]
    );
}

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        AppRoutingModule,
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        LoginModule,
        HomeModule,
        SharedModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [HttpClient]
            }
        }),
        SocialLoginModule
    ],
    providers: [
        SpinnerStore,
        StorageService,
        AuthenticationService,
        {provide: HTTP_INTERCEPTORS, useClass: UrlInterceptor, multi: true},
        AuthService,
        {
            provide: AuthServiceConfig,
            useFactory: socialConfigs
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
