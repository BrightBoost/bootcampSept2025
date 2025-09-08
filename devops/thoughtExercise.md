### Exercise: Manual Deployment Thought Experiment

#### Scenario: Deploying a Web Application for a Growing Business

You are tasked with manually deploying a **React frontend** and a **Node.js API backend** for a growing business. Initially, the business has **10 clients**, but within the next 6 months, they expect the number of clients to increase to **500**. As part of the growth, they are expanding to different geographic locations with **regional servers** and need to consider the scalability of their deployments.
The business requires that each client should have their own subdomain, and the backend should handle **client-specific configurations**. They also require some **regional variations** in configuration, such as different APIs for different regions or countries, possibly influenced by legal or service-level agreement (SLA) requirements.
Your task is to write a **Deployment Handbook** that outlines how to manually deploy the system, considering the challenges at each stage of scaling. You will answer the following questions based on various stages of growth for the company and the increasing complexity of deployments.
---
### **Part 1: Initial Setup (for 10 Clients)**
Imagine that the business initially has **10 clients**, and you are deploying the React frontend and Node.js API backend to a **single server**.
1. **Subdomains for each client**:
- The React app must be deployed for each client on a separate subdomain (e.g., `client1.yourdomain.com`, `client2.yourdomain.com`).
- The Node.js API should handle requests for each client by fetching **client-specific configurations**.
**Questions**:
- How will you configure each subdomain on the server? What steps will you take to ensure that each subdomain is correctly pointed to the React app?
- How will you manage slight variations in configuration for each client (e.g., different API URLs, branding, etc.)? Describe the manual process you would follow to ensure the correct configuration for each client.
2. **Challenges**:
- What are some of the risks of manually configuring the subdomains and ensuring each client’s configuration is correct?
- How will you verify that all subdomains are correctly configured, especially when dealing with client-specific settings?
---
### **Part 2: Scaling Up (for 100 Clients)**
As the business grows to **100 clients**, your deployment process becomes more complex. You now need to deploy the React app to **multiple servers** to handle increased traffic, and you also need to scale the backend.
1. **Frontend Deployment**:
- Deploying multiple React app instances across different servers.
- You may need to use a **load balancer** to distribute traffic across frontend servers.
**Questions**:
- How will you configure multiple frontend servers to serve the React app for different subdomains? What steps will you take to ensure that the subdomains are correctly routed to the right server?
- What process will you use to update all the frontend servers when you deploy new versions of the app? How do you ensure there is no downtime during the deployment?
2. **Backend Deployment**:
- You may need to deploy multiple instances of the backend API to handle the increased traffic. This might involve using **load balancing** to distribute API requests.
**Questions**:
- How will you manually scale the backend API (e.g., deploying multiple instances)? What tools or configurations will you use to ensure load balancing is correctly set up?
- As more clients come online, how will you ensure that each API instance is using the correct client-specific data? How will you manage different client configurations across multiple API instances?
3. **Database Considerations**:
- As the system scales, your database may become a bottleneck. You may need to think about **database replication** and **sharding**.
**Questions**:
- How will you manually manage the database as it grows? What steps will you take to replicate data or shard it across different databases for each client or region?
- How will you ensure data consistency across your backend API and database instances?
---
### **Part 3: Scaling Further (for 500 Clients)**
The business now has **500 clients**, and the infrastructure needs to be more robust, with deployments spread across **multiple geographic regions**.
1. **Frontend Deployment across Regions**:
- You need to deploy the React app to servers in different geographic regions (e.g., the US, Europe, and Asia) and use **CDNs** to serve static files efficiently across the globe.
**Questions**:
- How will you manually deploy the React app across multiple regions? How will you ensure that each client’s subdomain points to the correct regional server?
- What steps will you take to configure a **Content Delivery Network (CDN)** to serve static files to clients in different regions?
2. **Backend API Deployment**:
- You now need to deploy the backend API to **multiple regions** to reduce latency for clients in different parts of the world.
- Each region may need to interact with its own **region-specific database**.
**Questions**:
- How will you manage the backend deployment across multiple regions? What steps will you take to ensure that each region has its own instance of the API and is correctly serving the clients in that region?
- How will you handle **cross-region traffic**? Will requests from one region always be routed to the closest backend instance, or will there be specific configurations for handling cross-region requests?
- What challenges will you face in keeping the **databases consistent** across different regions, and how will you manually handle replication?
---
### **Part 4: Client-Specific Configurations**
As the client base grows, the business needs to offer **custom configurations** for each client. These configurations could include custom branding, specific features, or integrations with external systems.
1. **Managing Client Configurations**:
- Each client may have different requirements that need to be reflected in both the frontend and backend (e.g., different API URLs, custom branding, special features).
**Questions**:
- How will you manage and deploy **client-specific configurations** across your system? What files or configurations will you need to maintain for each client, and how will you ensure they are up to date?
- How will you handle **client-specific customizations** such as branding, logos, or custom API endpoints? How will you ensure that the correct configuration is deployed to each client’s subdomain?
2. **Challenges**:
- What issues might arise if you have hundreds of clients, each with their own custom configurations? How will you ensure that updates are consistent across all clients?
- What strategies will you employ to prevent errors when updating configurations for multiple clients at once?
---
### **Real-Life Challenges in Manual Deployments**
As you write your handbook, consider the following **real-life issues** that would arise from doing everything manually:
1. **Inconsistent Environments**:
- How do you ensure consistency across all deployment environments (e.g., development, staging, production) when managing everything manually? What risks do you face if configurations are not properly synchronized across environments?
2. **Downtime During Deployments**:
- Deployments may result in downtime. How will you handle **zero-downtime deployments** or minimize the impact on clients during updates?
3. **Scaling and Load Balancing**:
- Manually configuring **load balancing** and scaling across multiple servers and regions can become complex. What strategies will you use to ensure that scaling is done effectively?
4. **Database and Data Management**:
- As the number of clients and the amount of data grows, how will you manage the **database scaling** manually? How do you ensure data consistency across multiple backend instances?


