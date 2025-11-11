import { Component } from '@angular/core';
import { Ingredients } from '../../models/ingredients';
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-despensa',
  imports: [FormsModule, NgIf, NgFor],
  templateUrl: './despensa.component.html',
  styleUrl: './despensa.component.css'
})
export class DespensaComponent {
  inventory: Ingredients[] = [];
  newIngredient: Partial<Ingredients> = {};

  addIngredient() {
    const ingredient: Ingredients = {
      id: Date.now().toString(),
      name: this.newIngredient.name!,
      quantity: this.newIngredient.quantity!,
      unit: this.newIngredient.unit!,
    };
    this.inventory.push(ingredient);
    this.newIngredient = {};
  }

  updateQuantity(item: Ingredients, change: number) {
    item.quantity = Math.max(0, item.quantity + change);
  }

  deleteIngredient(item: Ingredients) {
    this.inventory = this.inventory.filter(i => i.id !== item.id);
  }

}
