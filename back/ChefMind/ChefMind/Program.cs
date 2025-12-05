using ChefMind;
using ChefMind.Mappers;
using ChefMind.Models.Database;
using ChefMind.Services;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using System.Text;

var builder = WebApplication.CreateBuilder(args);

builder.Services.Configure<Settings>(builder.Configuration.GetSection(Settings.SECTION_NAME));

builder.Services.AddControllers();
builder.Services.AddAuthentication()
            .AddJwtBearer(options =>
            {
                options.TokenValidationParameters = new TokenValidationParameters()
                {
                    ValidateIssuer = false,
                    ValidateAudience = false,

                    // INDICAMOS LA CLAVE
                    IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"]))
                };
            });


//Base de datos
builder.Services.AddDbContext<ChefsMindContext>(options =>
{
    options.UseSqlite($"Data Source=ChefsMind.db");
});

builder.Services.AddScoped<UnitOfWork>();


//Servicios
builder.Services.AddScoped<AuthService>();
builder.Services.AddScoped<UserService>();


//Settings
builder.Services.Configure<Settings>(builder.Configuration.GetSection("Settings"));
builder.Services.AddSingleton(sp => sp.GetRequiredService<IOptions<Settings>>().Value);


//Mappers
builder.Services.AddTransient<UserMapper>();



builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// CORS
builder.Services.AddCors(options =>
{
    options.AddDefaultPolicy(builder =>
    {
        builder.AllowAnyOrigin()
               .AllowAnyHeader()
               .AllowAnyMethod()
               .WithMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    });
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

await SeedDataBase(app.Services);


app.Run();

static async Task SeedDataBase(IServiceProvider serviceProvider)
{
    using IServiceScope scope = serviceProvider.CreateScope();
    using ChefsMindContext irContext = scope.ServiceProvider.GetRequiredService<ChefsMindContext>();

    if (irContext.Database.EnsureCreated())
    {
        Seeder seeder = new Seeder(irContext);
        await seeder.SeedAsync();
    }
}

