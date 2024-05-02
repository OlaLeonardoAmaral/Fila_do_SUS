import { IMAGE_CONFIG, NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgOptimizedImage, LoginComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  providers: [
    {
      provide: IMAGE_CONFIG,
      useValue: {
        breakpoints: [16, 48, 96, 128, 384, 640, 750, 828, 1080, 1200, 1920]
      }
    },
  ],
})
export class HeaderComponent {

}
