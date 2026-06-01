import { useState } from "react";
import FormProduto from "../components/FormProduto";

function Home({ paginaVisivel }) {
  // Estado inicial do CRUD populado com os dados originais do seu HTML
  const [produtos, setProdutos] = useState([
    { nome: "Cubo Profissional 3x3", preco: "49,90", precoAntigo: "80,00", imagem: "cubo1.jpg", categoria: "Profissional" },
    { nome: "Cubo Magnético 3x3", preco: "85,40", precoAntigo: "129,90", imagem: "cubo2.jpg", categoria: "Magnético" },
    { nome: "Cubo 2x2 Speed", preco: "39,90", precoAntigo: "60,00", imagem: "cubo3.jpg", categoria: "Speed" },
    { nome: "Cubo 4x4 Profissional", preco: "110,00", precoAntigo: "150,00", imagem: "cubo4.jpg", categoria: "Profissional" },
    { nome: "Cubo 5x5 Avançado", preco: "159,90", precoAntigo: "200,00", imagem: "cubo5.jpg", categoria: "Avançado" },
    { nome: "Megaminx", preco: "139,90", precoAntigo: "180,00", imagem: "cubo6.jpg", categoria: "Especiais" },
    { nome: "Pyraminx", preco: "59,90", precoAntigo: "90,00", imagem: "cubo7.jpg", categoria: "Especiais" },
    { nome: "Skewb", preco: "65,00", precoAntigo: "95,00", imagem: "cubo8.jpg", categoria: "Especiais" }
  ]);

  const [indiceEdicao, setIndiceEdicao] = useState(null);

  // Funções lógicas do seu CRUD conectadas ao estado
  function salvarProduto(produtoCadastrado) {
    if (indiceEdicao !== null) {
      const novaLista = [...produtos];
      novaLista[indiceEdicao] = {
        ...produtoCadastrado,
        imagem: produtos[indiceEdicao].imagem || "cubo1.jpg"
      };
      setProdutos(novaLista);
      setIndiceEdicao(null);
    } else {
      const novoItem = {
        ...produtoCadastrado,
        imagem: "cubo1.jpg", // Imagem padrão para novos cadastros
        precoAntigo: null
      };
      setProdutos([...produtos, novoItem]);
    }
  }

  function excluirProduto(index) {
    const novaLista = produtos.filter((_, i) => i !== index);
    setProdutos(novaLista);
  }

  function editarProduto(index) {
    setIndiceEdicao(index);
  }

  // ===== RETORNO DE TELAS CONFORME O MENU NAV =====
  
  // 1. TELA DE INÍCIO
  if (paginaVisivel === "inicio") {
    return (
      <div>
        <img src="/images/banner.jpeg" alt="banner cubo magico" className="banner" />
        <div className="divPromo">
          <h1>Promoções!!!!!</h1>
        </div>
        <div className="divCenter">
          {produtos.slice(0, 2).map((item, i) => (
            <div className="produto" key={i}>
              <img src={item.imagem} alt={item.nome} />
              <h3>{item.nome}</h3>
              {item.precoAntigo && <p className="preco-antigo">R$ {item.precoAntigo}</p>}
              <p className="preco">R$ {item.preco}</p>
              <button>Adicionar ao carrinho</button>
            </div>
          ))}
        </div>
      </div>
    );
  }

  // 2. TELA DE PRODUTOS DINÂMICA (Exibe o que está cadastrado no CRUD)
  if (paginaVisivel === "produtos") {
    return (
      <div>
        <div className="banner-produtos">
          <h1>Nossos Produtos!!</h1>
        </div>
        <div className="grid-produtos">
          {produtos.map((item, i) => (
            <div className="produto" key={i}>
              <img src={item.imagem} alt={item.nome} />
              <h3>{item.nome}</h3>
              {item.precoAntigo && <p className="preco-antigo">R$ {item.precoAntigo}</p>}
              <p className="preco">R$ {item.preco}</p>
              <button>Adicionar</button>
            </div>
          ))}
        </div>
      </div>
    );
  }

  // 3. TELA SOBRE
  if (paginaVisivel === "sobre") {
    return (
      <div>
        <div className="banner-sobre">
          <h1>Sobre a FM Store Cube</h1>
        </div>
        <div className="sobre-container">
          <div className="sobre-card">
            <h2>Quem somos</h2>
            <p>
              A FM Store Cube é uma loja especializada em cubos mágicos e puzzles,
              criada para apaixonados por desafios e velocidade. Nosso objetivo é
              oferecer produtos de qualidade com preços acessíveis.
            </p>
          </div>
          <div className="sobre-card">
            <h2>Nossa missão</h2>
            <p>
              Levar diversão, raciocínio e desenvolvimento lógico para todas as
              idades, com produtos confiáveis e atendimento de qualidade.
            </p>
          </div>
          <div className="sobre-card">
            <h2>Por que escolher a gente?</h2>
            <ul>
              <li>✔ Produtos de alta qualidade</li>
              <li>✔ Preços acessíveis</li>
              <li>✔ Entrega rápida</li>
              <li>✔ Suporte ao cliente</li>
            </ul>
          </div>
        </div>
      </div>
    );
  }

  // 4. TELA CONTATO
  if (paginaVisivel === "contato") {
    return (
      <div>
        <div className="banner-contato">
          <h1>Fale com a gente</h1>
          <p>Tem alguma dúvida? Envie uma mensagem</p>
        </div>
        <div className="contato-container">
          <form className="form-contato" onSubmit={(e) => e.preventDefault()}>
            <input type="text" placeholder="Seu nome" required />
            <input type="email" placeholder="Seu email" required />
            <textarea placeholder="Sua mensagem..." rows="5" required></textarea>
            <button type="submit">Enviar mensagem</button>
          </form>
          <div className="contato-info">
            <h2>Outros contatos</h2>
            <p>Email: contato@fmstorecube.com</p>
            <p>WhatsApp: (31) 99999-9999</p>
            <p>Belo Horizonte - MG</p>
          </div>
        </div>
      </div>
    );
  }

  // 5. TELA DE CARRINHO
  if (paginaVisivel === "carrinho") {
    return (
      <div>
        <div className="carrinho-container">
          <div className="item-carrinho">
            <img src="/images/cubo1.jpg" alt="Item" />
            <div className="info">
              <h3>Cubo Profissional 3x3</h3>
              <p className="preco">R$ 49,90</p>
            </div>
            <span className="quantidade">Qtd: 1</span>
          </div>
        </div>
        <div className="total-carrinho">
          <h2>Total: R$ 49,90</h2>
          <button>Finalizar compra</button>
        </div>
      </div>
    );
  }

  // 6. TELA GERENCIADORA DO CRUD (ÁREA DO ADMIN)
  if (paginaVisivel === "admin") {
    return (
      <div style={{ background: "white", padding: "30px", margin: "30px 10%", borderRadius: "20px", boxShadow: "0 4px 8px rgba(0,0,0,0.2)" }}>
        <h1 style={{ color: "#3483fa", marginBottom: "20px" }}>Gerenciador de Estoque FM Store</h1>
        
        <FormProduto
          salvarProduto={salvarProduto}
          produtoEditando={indiceEdicao !== null ? produtos[indiceEdicao] : null}
        />

        <h2 style={{ marginTop: "40px", borderTop: "2px solid #eee", paddingTop: "20px" }}>Produtos em Estoque ({produtos.length})</h2>
        
        <div style={{ display: "flex", flexDirection: "column", gap: "10px", marginTop: "15px" }}>
          {produtos.map((item, index) => (
            <div key={index} style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "15px", border: "1px solid #ddd", borderRadius: "10px", background: "#f9f9f9" }}>
              <div>
                <strong style={{ fontSize: "16px" }}>{item.nome}</strong> 
                <span style={{ marginLeft: "15px", color: "#00a650", fontWeight: "bold" }}>R$ {item.preco}</span>
                <span style={{ marginLeft: "15px", padding: "2px 8px", background: "#eee", borderRadius: "5px", fontSize: "12px" }}>{item.categoria}</span>
              </div>
              <div style={{ display: "flex", gap: "10px" }}>
                <button onClick={() => editarProduto(index)} style={{ background: "#ffc107", color: "black", marginTop: 0 }}>Editar</button>
                <button onClick={() => excluirProduto(index)} style={{ background: "#dc3545", marginTop: 0 }}>Excluir</button>
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  }

  return null;
}

export default Home;