import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from 'angularx-social-login';
import {User} from '../../models/user';
import {AssociationService} from '../../services/association/association.service';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {
  user: User;

  constructor(private OAuth: AuthService, private authenticationService: AuthenticationService,
              private associationService: AssociationService, private router: Router) {
  }

  ngOnInit() {
    this.user = this.authenticationService.user;
  }

  logout() {
    this.authenticationService.removeUser();
    this.OAuth.signOut().then(data => {
      this.router.navigate([`/login`]);
    });
  }
}
