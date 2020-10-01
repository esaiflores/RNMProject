$(document).ready(() => {


    $('#searchForm').on('submit', (e) => {
        let searchText = $('#searchText').val();
        getMovies(searchText);
        e.preventDefault();
    });
});

function getMovies(searchText){
    let url = "https://www.omdbapi.com/?s=" + searchText + '&apikey=57d7cffb';
    axios.get(url)
        .then((response) => {
            console.log(response);
            let movies = response.data.Search;
            let output = '';
            $.each(movies, (index, movie) => {
                output += `
          <div class="col-md-3">
            <div class="well text-center">
              <img src="${movie.Poster}">
              <h5 style="color: white">${movie.Title}</h5>
              <a onclick="movieSelected('${movie.imdbID}')" class="btn btn-primary" href="#">Movie Details</a>
            </div>
          </div>
        `;
            });

            $('#movies').html(output);
        })
        .catch((err) => {
            console.log(err);
        });
}


function movieSelected(id){
    sessionStorage.setItem('movieId', id);
    window.location = 'movie';
    return false;
}

function getMovie(){
    let movieId = sessionStorage.getItem('movieId');
    let url = "https://www.omdbapi.com/?i=" + movieId + '&apikey=57d7cffb';

    axios.get(url)
        .then((response) => {
            console.log(response);
            let movie = response.data;

            let output =`
        <div class="row">
          <div class="col-md-4 mt-4">
            <img src="${movie.Poster}" class="thumbnail">
          </div>
          <div class="col-md-8 mt-4">
            <h2>${movie.Title}</h2>
            
            
              <div class="py-5">
    <div class="row">
            <div class="col-lg-3 mb-5">
        <a data-toggle="collapse" href="#collapseExample1" role="button" aria-expanded="true" aria-controls="collapseExample1" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Genre</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample1" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Genre}</p>
            </div>
          </div>
        </div>
      </div>
      
        <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="true" aria-controls="collapseExample2" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Release Date</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample2" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Released}</p>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="true" aria-controls="collapseExample3" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Rated</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample3" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Rated}</p>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample4" role="button" aria-expanded="true" aria-controls="collapseExample4" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">IMDB Rating</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample4" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.imdbRating}</p>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample5" role="button" aria-expanded="true" aria-controls="collapseExample5" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Director</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample5" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Director}</p>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample6" role="button" aria-expanded="true" aria-controls="collapseExample6" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Actors</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample6" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Actors}</p>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-lg-3 ">
        <a data-toggle="collapse" href="#collapseExample7" role="button" aria-expanded="true" aria-controls="collapseExample7" class="btn btn-primary btn-block py-2 shadow-sm with-chevron">
          <p class="d-flex align-items-center justify-content-between mb-0 px-3 py-2"><strong class="text-uppercase">Runtime</strong><i class="fa fa-angle-down"></i></p>
        </a>
        <div id="collapseExample7" class="collapse shadow-sm show">
          <div class="card">
            <div class="card-body">
              <p class="font-italic mb-0 text-muted">${movie.Runtime}</p>
            </div>
          </div>
        </div>
      </div>
      
      
      
      
    

          </div>
        </div>
        <div class="row">
          <div class="well">
            <h3 style="color: white">Plot</h3>
            <h5 style="color: white">${movie.Plot}</h5>
            <hr>
            <a href="http://imdb.com/title/${movie.imdbID}" target="_blank" class="btn btn-primary">View IMDB</a>
            <a href="/index" class="btn btn-default" style="color: white">Go Back To Search</a>
          </div>
        </div>
      `;

            $('#movies').html(output);
        })
        .catch((err) => {
            console.log(err);
        });


    // function addFavorite(event, movie) {
    //     const addToFavoritesButton =
    //         event.target.parentElement.querySelector('button.add-to-favorites')
    //
    //     addToFavoritesButton.addEventListener('click', () => {
    //         axios.post('/favorites.json', movie)
    //             .then(() => addToFavoritesButton.innerHTML = 'Favorited!')
    //             .catch((err) => handleError(err))
    //     })
    // }
}