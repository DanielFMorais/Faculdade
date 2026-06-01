import { useState, useEffect } from "react";

function FormProduto({ salvarProduto, produtoEditando }) {
  const [nome, setNome] = useState("");
  const [preco, setPreco] = useState("");
  const [categoria, setCategoria] = useState("");

  useEffect(() => {
    if (produtoEditando) {
      setNome(produtoEditando.nome);
      setPreco(produtoEditando.preco);
      setCategoria(produtoEditando.categoria);
    }
  }, [produtoEditando]);

  function enviarFormulario(event) {
    event.preventDefault();
    salvarProduto({ nome, preco, categoria });
    setNome("");
    setPreco("");
    setCategoria("");
  }

  return (
    <form onSubmit={enviarFormulario} style={{ display: "flex", flexDirection: "column", gap: "12px", maxWidth: "400px" }}>
      <h3>{produtoEditando ? "Modificar Informações do Produto" : "Cadastrar Novo Cubo"}</h3>
      
      <input
        type="text"
        placeholder="Nome do produto"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
        style={{ padding: "10px", borderRadius: "8px", border: "1px solid #ccc" }}
        required
      />
      
      <input
        type="text"
        placeholder="Preço (Ex: 89.90)"
        value={preco}
        onChange={(e) => setPreco(e.target.value)}
        style={{ padding: "10px", borderRadius: "8px", border: "1px solid #ccc" }}
        required
      />
      
      <input
        type="text"
        placeholder="Categoria"
        value={categoria}
        onChange={(e) => setCategoria(e.target.value)}
        style={{ padding: "10px", borderRadius: "8px", border: "1px solid #ccc" }}
        required
      />
      
      <button type="submit" style={{ background: "#00a650", color: "white", padding: "12px", border: "none", borderRadius: "8px", fontWeight: "bold" }}>
        {produtoEditando ? "Confirmar Edição" : "Adicionar ao Catálogo"}
      </button>
    </form>
  );
}

export default FormProduto;