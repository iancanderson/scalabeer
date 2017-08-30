object Main {
  def main(args: Array[String]) {
    printRecipe(Recipes.marzen)
  }

  def printRecipe(recipe: Recipe) {
    val originalGravity = recipe.originalGravity
    val finalGravity = recipe.finalGravity
    val abv = recipe.abv

    println(f"IBUs: ${recipe.ibu}%3.2f")
    println(f"Original Gravity: ${originalGravity.amount}%1.3f")
    println(f"Final Gravity: ${finalGravity.amount}%1.3f")
    println(f"ABV: ${abv}%3.2f%%")
  }
}
