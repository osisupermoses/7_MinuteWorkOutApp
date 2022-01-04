package com.osisupermoses.a7_minuteworkoutapp.utils

import com.osisupermoses.a7_minuteworkoutapp.model.ExerciseModel
import com.osisupermoses.a7_minuteworkoutapp.R

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks =
            ExerciseModel(
                1,
                "Jumping Jacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
        exerciseList.add(jumpingJacks)

        val wallSits =
            ExerciseModel(
                2,
                "Wall Sit",
                R.drawable.ic_wall_sits,
                false,
                false
            )
        exerciseList.add(wallSits)

        val pushUps =
            ExerciseModel(
                3,
                "Push Up",
                R.drawable.ic_push_ups,
                false,
                false
            )
        exerciseList.add(pushUps)

        val abCrunch =
            ExerciseModel(
                4,
                "Abdominal Crunch",
                R.drawable.ic_ab_crunch,
                false,
                false
            )
        exerciseList.add(abCrunch)

        val stepUpOn =
            ExerciseModel(
                5,
                "Step-Up onto Chair",
                R.drawable.ic_step_up,
                false,
                false
            )
        exerciseList.add(stepUpOn)

        val squat =
            ExerciseModel(
                6,
                "Squat",
                R.drawable.ic_squat,
                false,
                false
            )
        exerciseList.add(squat)

        val tricepsDipOnChair =
            ExerciseModel(
                7,
                "Triceps Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false
            )
        exerciseList.add(tricepsDipOnChair)

        val plank =
            ExerciseModel(
                8,
                "Plank",
                R.drawable.ic_plank,
                false,
                false

            )
        exerciseList.add(plank)

        val highKnees =
            ExerciseModel(
                9,
                "High Knees Running In Place",
                R.drawable.ic_high_knees,
                false,
                false
            )
        exerciseList.add(highKnees)

        val lunges =
            ExerciseModel(
            10, "Lunges",
            R.drawable.ic_lunges,
            false,
            false
            )
        exerciseList.add(lunges)

        val pushupsAndRotation =
            ExerciseModel(
                11,
                "Push up and Rotation",
                R.drawable.ic_push_ups_and_rotation,
                false,
                false
            )
        exerciseList.add(pushupsAndRotation)

        val sidePlank =
            ExerciseModel(
                12,
                "Side Plank",
                R.drawable.ic_side_plank,
                false,
                false
            )
        exerciseList.add(sidePlank)

        return exerciseList
    }
}