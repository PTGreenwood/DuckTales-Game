package uq.deco2800.ducktales.renderingEngine;

import uq.deco2800.ducktales.resources.ResourceType;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static uq.deco2800.ducktales.resources.ResourceType.*;


/**
 * This class will hold the rendering information for all buildings in the game
 *
 * Created by Khoi on 28/08/2016.
 */
public class WorldEntityRenderingInfo {
    /**
     * The lowest visible points of the corresponding entities
     */
    private final int HOSPITAL_START_POINT = 40;

    private static WorldEntityRenderingInfo ourInstance = new WorldEntityRenderingInfo();

    /**
     * The variable holding the rendering information for all entities
     */
    private ConcurrentHashMap<ResourceType, RenderingEntity> entities;

    public static WorldEntityRenderingInfo getInstance() {
        return ourInstance;
    }

    private WorldEntityRenderingInfo() {
        this.entities = new ConcurrentHashMap<>();

        addEntities();
    }

    /**
     * Initialize and all the entities to the list
     */
    private void addEntities() {
        // HOSPITAL
        entities.put(HOSPITAL, new RenderingEntity(new int[][] {
                {1, 1, 1},
                {1, 1, 1}
        }, HOSPITAL_START_POINT));

    }

    public int[][] getRenderingMatrix(ResourceType entity) {
        return entities.get(entity).getRenderingMatrix();
    }

    public int getStartPoint(ResourceType entity) {
        if (entities.containsKey(entity)) {
            return entities.get(entity).getStartPoint();
        } else {
            return 0;
        }

    }

    /**
     * The class holding the rendering information of a single entity
     */
    private class RenderingEntity {
        private final int[][] renderingMatrix;
        private int startPoint;

        public RenderingEntity(int[][] matrix, int startPoint) {
            this.renderingMatrix = matrix;
            this.startPoint = startPoint;
        }

        public int[][] getRenderingMatrix() {
            return renderingMatrix;
        }

        public int getStartPoint() {
            return startPoint;
        }
    };
}
