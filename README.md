# Java Spring Template
https://achtelik.github.io/java-spring-template

This project combines my personal best practices. I will handle different usecases like:

* Project structure
* Exception handling
* DB integration and migration with MongoDB
* OAuth2 authentication
* ...

Feel free to use this template and to give feedback.

## Endpoints

* __Swagger__: http://localhost:8080/backend/swagger-ui.html
* __Actuator__: Swagger: http://localhost:8080/backend/actuator

## Structure

The project contains two main packages:

* __commons__: Contains business use case independent code. You can reuse it in every project.
* __modules__: Contains the business use case specific code. Delete it, you have your own business code.

__If you want to use this template. Clone or copy it and just remove the modules/* folders. You only need the commons
for your use cases.__

## Build and Run

1. Start docker containers.

   docker-compose up

2. Build and run the application.

   ./mvnw spring-boot:run

## Topics
* [Environment variables](src/main/resources/application.md)

## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/achtelik/java-spring-template/edit/gh-pages/index.md) to maintain
and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in
your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1

## Header 2

### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details
see [Basic writing and formatting syntax](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
.

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in
your [repository settings](https://github.com/achtelik/java-spring-template/settings/pages). The name of this theme is
saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/)
or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
