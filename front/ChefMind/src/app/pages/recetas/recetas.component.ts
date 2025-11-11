import { Component } from '@angular/core';
import { Recipe } from '../../models/recipe';
import { CommonModule, NgIf } from '@angular/common';


@Component({
  selector: 'app-recetas',
  imports: [NgIf, CommonModule],
  templateUrl: './recetas.component.html',
  styleUrls: ['./recetas.component.css']
})
export class RecetasComponent {
  recipes: Recipe[] = [];
  filteredRecipes: Recipe[] = [];
  searchTerm: string = '';

  onSearch(event: Event) {
    const term = (event.target as HTMLInputElement).value.toLowerCase();
    this.filteredRecipes = this.recipes.filter(r =>
      r.ingredients.toLowerCase().includes(term)
    );
  }

  constructor() {
    this.filteredRecipes = this.recipes;
  }
}
