using System.Collections;
using ChefMind.Models.Database.Dto;
using ChefMind.Models.Database.Entities;
using ChefMind.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;


namespace ChefMind.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private AuthService _authService;

        public AuthController(AuthService authService)
        {
            _authService = authService;
        }

        [HttpPost("register")]
        public async Task<ActionResult<string>> RegisterUserAsync([FromBody] UserRegister userRegister)
        {
            Response response = new();
            User newUser = await _authService.Register(userRegister);
            if (newUser != null)
            {
                string stringToken = _authService.ObtainToken(newUser);
                if (stringToken == null) {
                    return Unauthorized();
                }
                response.token = stringToken;
                return Ok(response);
            }
            else
            {
                return Unauthorized();
            }

        }
        [HttpPost("login")]
        public async Task<ActionResult<Response>> LoginUser([FromBody] UserLogin userLogin)
        {
            Response response = new();

            if (userLogin == null || string.IsNullOrEmpty(userLogin.UserNameOrEmail) || string.IsNullOrEmpty(userLogin.Password))
            {
                return Unauthorized();
            }


            String token = await _authService.Login(userLogin);

            if (token == null)
            {
                return Unauthorized();
            }

            response.token = token;
            return Ok(response);

        }
    }
}
