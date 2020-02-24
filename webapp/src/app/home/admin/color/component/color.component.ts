import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {User} from '../../../../models/user';
import {ColorService} from "../../../../services/color/color.service";
import {Color} from "../../../../models/color";

@Component({
  selector: 'color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.less']
})
export class ColorComponent {
  user: User;

  columnsDefinition: string[] = ['id', 'libelle', 'codeHexa'];
  dataSource: MatTableDataSource<Color> = new MatTableDataSource<Color>();

  constructor(private colorService: ColorService, private router: Router) {
  }

  getColors() {
    this.colorService.getAll().subscribe(data => {
      this.dataSource.data = data;
    });
  }
}
