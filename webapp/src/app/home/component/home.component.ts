import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {AuthService} from 'angularx-social-login';
import {Association} from '../../models/association';
import {User} from '../../models/user';
import {AssociationService} from '../../services/association/association.service';
import {Color} from '../../models/color';
import {ColorService} from '../../services/color/color.service';
import {Size} from '../../models/size';
import {SizeService} from '../../services/size/size.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent {
  socialusers: User;

  columnsDefinition: string[] = ['name', 'mail', 'president'];
  dataSource: MatTableDataSource<Association> = new MatTableDataSource<Association>();

  columnsDefinitionColor: string[] = ['libelle', 'codeHexa'];
  dataSourceColor: MatTableDataSource<Color> = new MatTableDataSource<Color>();

  columnsDefinitionSize: string[] = ['libelle'];
  dataSourceSize: MatTableDataSource<Size> = new MatTableDataSource<Size>();

  constructor(private associationService: AssociationService,
              private colorService: ColorService, private sizeService: SizeService, private OAuth: AuthService,
              private router: Router) {
  }

  ngOnInit() {
    this.socialusers = JSON.parse(localStorage.getItem('socialusers'));
    console.log(this.socialusers.photoUrl);
  }

  logout() {
    alert(1);
    this.OAuth.signOut().then(data => {
      debugger;
      this.router.navigate([`/login`]);
    });
  }

  getAssociations() {
    this.associationService.getAll().subscribe(data => {
      this.dataSource.data = data;
    });
  }

  getColors() {
    this.colorService.getAll().subscribe(data => {
      this.dataSourceColor.data = data;
    });
  }

  getSizes() {
    this.sizeService.getAll().subscribe(data => {
      this.dataSourceSize.data = data;
    });
  }
}
