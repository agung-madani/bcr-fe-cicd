# Use official Nginx base image
FROM registry.redhat.io/rhel9/nginx-124:9.5-1741883852

# Set working directory
# WORKDIR /usr/share/nginx/html

# Remove default Nginx static files
# RUN rm -rf ./*

# Copy built React files
COPY dist/ /opt/app-root

# Change permissions to allow OpenShift's non-root user to write
# RUN chmod -R g+w /var/cache/nginx /var/run /var/log/nginx && \
#     chown -R 1001:0 /var/cache/nginx /var/run /var/log/nginx && \
#     chmod -R 777 /var/cache/nginx

# RUN chown -R 1001:0 /tmp/src

# Expose port 8080 instead of 80 (OpenShift default)
EXPOSE 8080

# Run Nginx as a non-root user
USER 1001

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]