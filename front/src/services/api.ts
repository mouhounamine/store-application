export async function fetchProductList() {
  try {
    const response = await fetch("http://localhost:8081/api/products");
    const responseBody = await response.json();
    console.log("Product List:", responseBody);
    return responseBody;
  } catch (e) {
    console.error("An error occurred while fetching product list:", e);
  }
}

export async function fetchProductById(productId: string) {
  try {
    const response = await fetch(
      `http://localhost:8081/api/products/${productId}`
    );
    const responseBody = await response.json();
    console.log("Product Details:", responseBody);
    return responseBody;
  } catch (e) {
    console.error("An error occurred while fetching product:", e);
  }
}

export async function createProduct(productData: any) {
  try {
    const response = await fetch("http://localhost:8081/api/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(productData),
    });
    const responseBody = await response.json();
    console.log("Created Product:", responseBody);
    return responseBody;
  } catch (e) {
    console.error("An error occurred while creating product:", e);
  }
}

export async function updateProduct(productId: string, productData: any) {
  try {
    const response = await fetch(
      `http://localhost:8081/api/products/${productId}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(productData),
      }
    );
    const responseBody = await response.json();
    console.log("Updated Product:", responseBody);
    return responseBody;
  } catch (e) {
    console.error("An error occurred while updating product:", e);
  }
}

export async function deleteProduct(productId: string) {
  try {
    const response = await fetch(
      `http://localhost:8081/api/products/${productId}`,
      {
        method: "DELETE",
      }
    );
    if (response.ok) {
      console.log(`Product with ID ${productId} deleted successfully.`);
    } else {
      console.error("Failed to delete product.");
    }
  } catch (e) {
    console.error("An error occurred while deleting product:", e);
  }
}
