using ChefMind.Models.Database.Dto;
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
            User newUser = await _authService
            if (userRegister != null) {

        }
    }
}
