using ChefMind.Models.Database.Dto;
using ChefMind.Models.Database.Entities;
using ChefMind.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

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
            User newUser = await _authService.Register(userRegister);
            if (newUser != null)
            {
                string stringToken = _authService.ObtainToken(newUser);
                return Ok(new
                {
                    accessToken = stringToken
                });
            }
            else
            {
                return Unauthorized();
            }

        }
    }
}
