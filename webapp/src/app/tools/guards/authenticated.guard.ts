import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';


@Injectable({
    providedIn: 'root'
})
export class AuthenticatedGuard implements CanActivate {

    constructor(private authenticationService: AuthenticationService,
                private router: Router) {
    }

    public canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        const user = this.authenticationService.user;

        if (user && user.authToken && user.idToken) {
            return true;
        } else {
            this.authenticationService.removeUser();
            this.router.navigate(['login']);
            return false;
        }
    }
}
