
  

# 🌐 Frontend Documentation - Product SPA

  

## 🚀 Framework: Angular 20  

This frontend project is developed using **Angular 20**, utilizing the latest modern features of the framework for better structure and maintainability.

---

## 🧱 Project Structure & Modern Features

### ✅ Standalone Components

The project uses **standalone components**, a new approach in Angular that eliminates the need for NgModules. This makes the component architecture simpler and more modular.
 
### 🔄 New Control Flow Syntax

It takes advantage of Angular 17’s **control flow syntax**, replacing traditional structural directives like `*ngFor` and `*ngIf` with:

```html

@for (item of items; track item.id) {
	<div>{{ item.name }}</div>
} 

@if (isVisible) {
	<p>Item is visible</p>
}

```
This improves template readability and reduces cognitive load when building UIs.
 
## 🧪 Testing

### 🧰 Tools
  
-  **Jasmine** for writing test cases

-  **Karma** as the test runner
  
### 📈 Coverage

  

The frontend project has **94% test coverage**, including:
- Component logic
- Services
- Utilities
 
> 📝 **Note:** The remaining uncovered code primarily includes minor edge cases or styling behavior.

---

## 🤖 A Note About Development

While I'm not a frontend developer, I made full use of **AI tools** to support me with **HTML and CSS best practices** and responsive layout ideas. This helped speed up development and ensure a polished user experience.

---  

## 📦 Running the Application

### 1. Install Dependencies

```bash
npm install
```
### 2. Start the Development Server
```bash
npm start
```
Or, alternatively:
```bash
ng serve
```
Open your browser at: http://localhost:4200
 
### 3. Run Unit Tests
```bash
ng test
```
This command runs all Jasmine tests and displays the test coverage report.