import {Component, NgZone} from '@angular/core';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {AuthService, GoogleLoginProvider} from 'angularx-social-login';
import {AuthenticationService} from '../../services/authentication.service';
import {ToastService} from '../../shared/toast/toast.service';

@Component({
    selector: 'alogin',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less']
})
export class LoginComponent {

    constructor(
        public OAuth: AuthService, private router: Router,
        private authenticationService: AuthenticationService,
        private translate: TranslateService,
        private toaster: ToastService, private zone: NgZone) {
    }

    socialSignIn(socialProvider: string) {
        let socialPlatformProvider;
        if (socialProvider === 'google') {
            socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
        }
        this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
            this.authenticationService.user = socialusers;
        }).catch(reason => {
            console.log('erreur', reason);
            let errMsg = this.translate.instant('login.error.500');
            this.toaster.alert(errMsg, 3000);
        }).finally(() => {
            this.authenticationService.authenticateUser(this.authenticationService.user.idToken).subscribe(user => {
                this.router.navigate(['home']);
            }, error => {
                console.log('erreur', error);
                let errMsg: string = this.translate.instant('login.error.500');

                if (error.status == 403) {
                    errMsg = this.translate.instant('login.error.403');
                }

                this.toaster.alert(errMsg, 3000);
            });
        });
    }

    contactUs() {
        this.toaster.info("Vous nous avez contacté", 3000);
    }
}
