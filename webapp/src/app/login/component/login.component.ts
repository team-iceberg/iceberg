import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService, GoogleLoginProvider} from 'angularx-social-login';
import {User} from '../../models/user';

@Component({
    selector: 'alogin',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {
    response;
    socialusers = new User();

    constructor(
        public OAuth: AuthService,
        private router: Router
    ) {
    }

    ngOnInit() {
    }

    public socialSignIn(socialProvider: string) {
        let socialPlatformProvider;
        if (socialProvider === 'google') {
            socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
        }
        this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
            console.log(socialProvider, socialusers);
            console.log(socialusers);
            this.router.navigate([`/home`]);
        });
    }

    Savesresponse(socialusers: User) {
        console.log(socialusers)
        // this.authenticationService.Savesresponse(socialusers).subscribe((res: any) => {
        //     debugger;
        //     console.log(res);
        //     this.socialusers = res;
        //     this.response = res.userDetail;
        //     localStorage.setItem('socialusers', JSON.stringify(this.socialusers));
        //     console.log(localStorage.setItem('socialusers', JSON.stringify(this.socialusers)));
        //     this.router.navigate([`/Dashboard`]);
        // })
    }
}