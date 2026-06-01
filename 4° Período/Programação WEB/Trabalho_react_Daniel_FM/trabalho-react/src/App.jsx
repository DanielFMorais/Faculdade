import { useState } from "react";
import Home from "./pages/Home";
import "./index.css"; 

function App() {
  // Define qual aba/página inicia aberta
  const [abaAtual, setAbaAtual] = useState("inicio");

  return (
    <>
      {/* ===== HEADER (TOPO DO SITE VINDOS DO SEU HTML) ===== */}
      <header className="topo">
        <a href="#inicio" onClick={() => setAbaAtual("inicio")}>
          <img src="logo.png" alt="FM Store Cube Logo" class="logo" />
        </a>

        {/* ===== MENU DE NAVEGAÇÃO INTERNA ===== */}
        <nav className="menu">
          <a href="#inicio" onClick={() => setAbaAtual("inicio")}>Inicio</a>
          <a href="#produtos" onClick={() => setAbaAtual("produtos")}>Produtos</a>
          <a href="#sobre" onClick={() => setAbaAtual("sobre")}>Sobre</a>
          <a href="#contato" onClick={() => setAbaAtual("contato")}>Contatos</a>
          <a href="#admin" onClick={() => setAbaAtual("admin")} style={{ color: "#3483fa", marginLeft: "30px", borderLeft: "2px solid #ccc", paddingLeft: "15px" }}>⚙️ CRUD Admin</a>
        </nav>

        {/* ===== CARRINHO ===== */}
        <div className="carrinho">
          <a href="#carrinho" onClick={() => setAbaAtual("carrinho")}>
            <img src="iconCarrinho.svg" alt="iconCarrinho" class="icone"/>
          </a>
        </div>
      </header>

      {/* COMPONENTE PRINCIPAL RENDERIZANDO A ABA SELECIONADA */}
      <div style={{ marginTop: "100px" }}>
        <Home paginaVisivel={abaAtual} />
      </div>
    </>
  );
}

export default App;