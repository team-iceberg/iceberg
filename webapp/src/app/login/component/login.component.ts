import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService, GoogleLoginProvider} from 'angularx-social-login';
import {User} from '../../models/user';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
    selector: 'alogin',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less']
})
export class LoginComponent {
    response;
    socialusers = new User();

    constructor(
        public OAuth: AuthService, private router: Router,
        private authenticationService: AuthenticationService) {
    }

    socialSignIn(socialProvider: string) {
        let socialPlatformProvider;
        if (socialProvider === 'google') {
            socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
        }
        this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
            this.authenticationService.user = socialusers;
            this.authenticationService.authenticateUser(socialusers.idToken).subscribe();
            this.router.navigate(['home']);
        });
    }
}
