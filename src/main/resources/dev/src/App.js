import { Route, Routes } from "react-router-dom"
import Produit from "./routes/produit";
import Produits from "./routes/produits";

function App() {
  return (
      <Routes>
        <Route exact path="/" element={<Produits />} />
        <Route path="/produit/:id" element={<Produit />} />
      </Routes>
  );
}

export default App;
