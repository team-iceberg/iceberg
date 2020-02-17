import {Component, NgZone} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService, GoogleLoginProvider} from 'angularx-social-login';
import {AuthenticationService} from '../../services/authentication.service';
import {throwError} from "rxjs";
import {TranslateService} from "@ngx-translate/core";
import {ToastService} from "../../shared/toast/toast.service";

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
            this.authenticationService.authenticateUser(socialusers.idToken).subscribe(value => {
              this.authenticationService.user = value;
              console.log(this.router.url);
              console.log(this.router.url);
            });
          this.router.navigate(['home']);
        });
    }


  // socialSignIn(socialProvider: string) {
  //   let socialPlatformProvider;
  //   if (socialProvider === 'google') {
  //     socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
  //   }
  //   this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
  //     this.authenticationService.authenticateUser(socialusers.idToken).subscribe(user => {
  //       this.authenticationService.user = user;
  //       this.router.navigate(['home']);
  //     }, error => {
  //       console.log("erreur", error);
  //       let errMsg: string;
  //       if (error.status != 401 && error.status != 403) {
  //         errMsg = this.translate.instant("login.error.500");
  //         this.toaster.alert(errMsg, 3000);
  //       }
  //       this.toaster.alert(errMsg);
  //     });
  //   });
  // }
}
