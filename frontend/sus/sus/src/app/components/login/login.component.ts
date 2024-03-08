import { Component} from '@angular/core';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})

export class LoginComponent {
  toggleForm() {
    const form = document.querySelector('form');
    if (form) {
      form.animate({ height: 'toggle', opacity: 'toggle' });
    }
  }
}
