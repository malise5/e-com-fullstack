import { useEffect, useState } from "react";
import "./App.css";
import ProductList from "./components/ProductList";
import CategoryFilter from "./components/CategoryFilter";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategories, setSelectedCategories] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    const fetchProducts = async () => {
      const response = await fetch("http://localhost:8081/api/products/all");
      const data = await response.json();
      console.log("Fetched products:", data);
      setProducts(data || []);
    };

    const fetchCategories = async () => {
      const response = await fetch("http://localhost:8081/api/categories/all");
      const data = await response.json();
      console.log("Fetched categories:", data);
      setCategories(data || []);
    };

    fetchProducts();
    fetchCategories();
  }, []);

  const handleSearchCahnge = (e) => {
    const value = e.target.value;
    setSearchTerm(value);
  }

  const handleSortChange = (e) => {
    const value = e.target.value;
    setSortOrder(value);
  }

  const handleCategoryFilter = (categoryId) => {
    setSelectedCategories(categoryId ? Number(categoryId) : null);
  }

  const filteredProducts = products.filter((product) => {
    return (
      (selectedCategories ? product.category.id === selectedCategories : true)
      && (product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        product.description.toLowerCase().includes(searchTerm.toLowerCase()))
      )
  }).sort((a, b) => {
    const priceA = a.price;
    const priceB = b.price;

    if (sortOrder === "asc") {
      return priceA - priceB;
    } else if (sortOrder === "desc") {
      return priceB - priceA;
    }
    return 0;
  })

  return (
    <div className="container">
      <h1 className="text-4xl font-bold my-4">Product Catalog</h1>
      <div className="row align-items-center mb-4">
        <div className="col-md-3 col-sm-12 mb-2">
          <CategoryFilter
            categories={categories}
            onSelect={handleCategoryFilter}
          />
        </div>
        <div className="col-md-5 col-sm-12 mb-2">
          <input
            type="text"
            className="form-control"
            placeholder="Search products..."
            value={searchTerm}
            onChange={handleSearchCahnge}
          />
        </div>

        <div className="col-md-4 col-sm-12 mb-2">
          <select
            className="form-select"
            value={sortOrder}
            onChange={handleSortChange}
          >
            <option value="asc">Sort by Price: Low to High</option>
            <option value="desc">Sort by Price: High to Low</option>
          </select>
        </div>
      </div>

      <div>
        {filteredProducts.length > 0 ? (
          <ProductList products={filteredProducts} />
        ) : (
          <h1 className="text-2xl font-bold">No products found</h1>
        )}
      </div>
    </div>
  );
}

export default App;
