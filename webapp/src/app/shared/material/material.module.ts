import {NgModule} from '@angular/core';
import {
    MatButtonModule,
    MatDividerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatTableModule,
    MatProgressSpinnerModule,
    MatToolbarModule
} from '@angular/material';

@NgModule({
    imports: [
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatProgressSpinnerModule,
        MatToolbarModule
    ],
    exports: [
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatProgressSpinnerModule,
        MatToolbarModule
    ]
})
export class MaterialModule {
}
