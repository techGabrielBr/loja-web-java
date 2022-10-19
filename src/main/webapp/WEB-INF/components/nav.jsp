<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <span class="navbar-brand mb-0 h1">Loja Web</span>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" 
    	aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
      <ul class="navbar-nav w-100 justify-content-end">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Produtos
          </a>
          <ul class="dropdown-menu dropdown-menu-dark">
            <li><a class="dropdown-item" href="./produto?mode=CriaProduto">Criar</a></li>
            <li><a class="dropdown-item" href="./produto?mode=ListaProduto">Listar</a></li>
            <li><a class="dropdown-item" href="./produto?mode=ListaProdutoPorCategoria">Listar por categoria</a></li>
          </ul>
        </li>
        <li class="nav-item ml-4">
        	<a class="nav-link" href="./categoria?mode=ListaCategoria" role="button">Categorias</a>
        </li>
      </ul>
    </div>
  </div>
</nav>