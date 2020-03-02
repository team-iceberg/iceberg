import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {AuthService} from 'angularx-social-login';
import {Association} from '../../../../models/association';
import {User} from '../../../../models/user';
import {AssociationService} from '../../../../services/association/association.service';
import {AuthenticationService} from '../../../../services/authentication.service';

@Component({
    selector: 'association',
    templateUrl: './association.component.html',
    styleUrls: ['./association.component.less']
})
export class AssociationComponent implements OnInit {
    user: User;

    columnsDefinition: string[] = ['name', 'mail', 'president'];
    dataSource: MatTableDataSource<Association> = new MatTableDataSource<Association>();

    constructor(private OAuth: AuthService, private authenticationService: AuthenticationService,
                private associationService: AssociationService, private router: Router) {
    }

    ngOnInit() {
        this.user = this.authenticationService.user;
    }

    getAssociations() {
        this.associationService.getAll().subscribe(data => {
            this.dataSource.data = data;
        });
    }
}
